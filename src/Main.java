import com.converter.StreamM4a;
import com.converter.StreamMp3;
import com.converter.StreamOgg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String formats[] = {"mp3", "m4a", "ogg"};
        int format_input;
        int format_output;
        StreamM4a m4a = new StreamM4a();
        StreamMp3 mp3 = new StreamMp3();
        StreamOgg ogg = new StreamOgg();
        Scanner scan = new Scanner(System.in);
        String name_input;
        String name_output;
        System.out.println("Inform the input format:");
        System.out.print("[1] - Mp3\n[2] - M4a\n[3] - Ogg\n");
        format_input = scan.nextInt()-1;
        System.out.println("Inform the name input file:");
        name_input = scan.next();

        System.out.println("Inform the output format:");
        System.out.print("[1] - Mp3\n[2] - M4a\n[3] - Ogg\n");
        format_output = scan.nextInt()-1;

        System.out.println("Inform the name input file:");
        name_output = scan.next();

        switch (format_output){
            case 0:
                mp3.encoder(format_input,name_input);
                mp3.decoder(name_output);
                break;
            case 1:
                m4a.encoder(format_input,name_input);
                m4a.decoder(name_output);
                break;
            case 2:
                ogg.encoder(format_input,name_input);
                ogg.decoder(name_output);
                break;
            default:
                System.out.println("Inform a valid number");
        }

    }

    }
