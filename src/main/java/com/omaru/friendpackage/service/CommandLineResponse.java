package com.omaru.friendpackage.service;


import com.omaru.friendpackage.Packer;
import com.omaru.friendpackage.util.parser.Parser;
import com.omaru.friendpackage.util.parser.format.PackageFormatter;
import org.apache.commons.cli.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Optional;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

@Component
public class CommandLineResponse {
    private static final String DEFAULT_SCRIPT = "data.txt";

    public CommandLineResponse() {
    }

    public  void print(String... args) throws Exception {
        Options options = new Options();
        Option inputFileOption = new Option("i", true, "ingest testing data from path," +
                "if none provided reads from classpath by default");
        inputFileOption.setArgName("/path/to/file.txt");
        options.addOption(inputFileOption);
        CommandLineParser commandLineParser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("package-friend", options);
        CommandLine cmd = commandLineParser.parse(options, args);
        Optional<String> fileRoute = getFileRoute(cmd);
        if (fileRoute.isPresent()) {
            try (BufferedReader reader =
                         new BufferedReader(new FileReader(fileRoute.get()))) {
                printOutput(reader);
            }
        } else {
            Resource resource = new ClassPathResource(DEFAULT_SCRIPT);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
                printOutput(reader);
            }
        }
    }

    private void printOutput(BufferedReader reader)throws Exception {
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            System.out.println(PackageFormatter.format(new Packer(Parser.parse(line)).pack()));
        }
    }

    private Optional<String> getFileRoute(CommandLine cmd) {
        Optional<String> script = Optional.empty();
        if (cmd.hasOption("i")) {
            String value = cmd.getOptionValue("i");
            if (isNotBlank(value)) {
                script = Optional.of(value);
            }
        }
        return script;
    }

}