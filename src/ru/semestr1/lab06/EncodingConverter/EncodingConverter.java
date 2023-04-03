package ru.semestr1.lab06.EncodingConverter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import java.io.*;

public class EncodingConverter {

    public static void main(String[] args) {
        if ((args.length < 4) || (args.length %2==1) ){
            System.out.println("Invalid number of arguments");
            return;
        }

//        if (!args[0].matches(".*\\.txt") || !args[1].matches(".*\\.txt")) {
//            System.out.println("Invalid file path");
//            return;
//        }


        String[] encodings = Charset.availableCharsets().keySet().toArray(new String[0]);
        ArrayList<String> charsets = new ArrayList<String>(Arrays.asList(encodings));
        for (String encoding : encodings) {
            charsets.addAll(Charset.availableCharsets().get(encoding).aliases());
        }

//        for (int i = 2; i < 4; i++) {
//            final int j = i;
//            try {
//                args[j] = charsets.stream().filter(charset -> charset.equalsIgnoreCase(args[j])).findFirst().get();
//            } catch (Exception e) {
//                System.out.println("Invalid encoding");
//                return;
//            }
//        }

//        for (int i = 2; i < args.length; i++) {
//            final int j = i;
//            try {
//                args[j] = charsets.stream().filter(charset -> charset.equalsIgnoreCase(args[j])).findFirst().get();
//            } catch (Exception e) {
//                System.out.println("Invalid encoding: " + args[j]);
//                return;
//            }
//        }
//
//        try {
//            convert(new File(args[0]), new File(args[1]), args[2], args[3]);
//        } catch (IOException e) {
//            System.out.println("Error while converting file");
//        }



            File source = new File(args[0]);
            File[] target = new File[args.length/2-1];
            String[] toEncodings = new String[args.length/2-1];
            for (int i = 0; i < args.length/2-1; i++) {
                target[i] = new File(args[i+1]);
                toEncodings[i] = args[i+2];
            }
            try {
                convert(source, args[1], target, toEncodings);
            } catch (IOException e) {
                System.out.println("Error while converting file");
            }
    }

//    public static void convert(File source, File target, String fromEncoding, String toEncoding) throws IOException {
//        try (
//                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(source), fromEncoding));
//                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), toEncoding));) {
//            char[] buffer = new char[1024];
//            int read;
//            while ((read = br.read(buffer)) != -1) {
//                bw.write(buffer, 0, read);
//            }
//        }
//    }

    //create convert method but with several encodings (File source, File[] target, String fromEncoding, String[] toEncodings)

    public static void convert(File source, String fromEncoding, File[] target,  String[] toEncodings) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(source), fromEncoding));) {
            char[] buffer = new char[1024];
            int read;
            for (int i = 0; i < toEncodings.length; i++) {
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target[i]), toEncodings[i]));) {
                    while ((read = br.read(buffer)) != -1) {
                        bw.write(buffer, 0, read);
                    }
                }
            }
        }
    }
}


