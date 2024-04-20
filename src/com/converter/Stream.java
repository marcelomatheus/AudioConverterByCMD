package com.converter;
import java.io.*;
import java.util.concurrent.TimeUnit;


public abstract class Stream {
    protected String dataInput;
    protected String dataOutput;
    protected int format_input;
    protected String formats[] = {"mp3", "m4a", "ogg"};
    protected String command;

    public void encoder(Integer format_input, String name_input) throws Exception{};
    public void decoder(String name_output) throws Exception{};
    public static void runCommand(String command) throws Exception {
        File location = new File("C:/audioconverter");
        System.out.println("Running in: " + location);
        System.out.println("Command: " + command);

        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(location);

        //This program runs on Windows operating system only
            builder.command("cmd.exe", "/c", command);

        Process process = builder.start();

        OutputStream outputStream = process.getOutputStream();
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();

        printStream(inputStream);
        printStream(errorStream);

        boolean isFinished = process.waitFor(30, TimeUnit.SECONDS);
        outputStream.flush();
        outputStream.close();

        if(!isFinished) {
            process.destroyForcibly();
        }
    }

    private static void printStream(InputStream inputStream) throws IOException {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        }
    }


}
