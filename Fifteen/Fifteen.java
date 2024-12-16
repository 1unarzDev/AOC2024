import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class Fifteen {
    public static void main(String[] args) throws IOException {
        List<String> map = Files.readAllLines(Paths.get("map.txt"));
        String moves = Files.readString(Paths.get("moves.txt"));
        ArrayList<String> mapVert = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < map.get(i).length(); i++){
            for(int j = 0; j < map.size(); j++){
                sb.append()
            }
        }

        for(char move : moves.toCharArray()){
            switch(move){
                case('^') -> {

                }
                case('>') -> {

                }
                case('v') -> {

                }
                case('<') -> {

                }
            }
        }
    }
}
