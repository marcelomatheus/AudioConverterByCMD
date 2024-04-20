package com.converter;

public class StreamMp3 extends Stream{

    @Override
    public void encoder(Integer format_input, String name_input) throws Exception {
        this.format_input = format_input;
        dataInput = (name_input+"."+formats[format_input]);
    }

    @Override
    public void decoder(String name_output) throws Exception {
        //output method (into m4u format)
        dataOutput = (name_output+".mp3");
        command = ("ffmpeg -i \""+dataInput+"\" "+"\""+dataOutput+"\"");
        runCommand(command);
    }
}
