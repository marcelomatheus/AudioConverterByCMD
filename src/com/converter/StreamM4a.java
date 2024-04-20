package com.converter;


import java.io.File;

public class StreamM4a extends Stream{

    @Override
    public void encoder(Integer format_input, String name_input) throws Exception {
        this.format_input = format_input;
        dataInput = (name_input+"."+formats[format_input]);
    }

    @Override
    public void decoder(String name_output) throws Exception {
        //output method (into m4u format)
        dataOutput = (name_output+".m4a");
        command = ("ffmpeg -i \""+dataInput+"\" "+"\""+dataOutput+"\"");
        runCommand(command);
    }
}
