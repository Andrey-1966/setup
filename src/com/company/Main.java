package com.company;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {

        //Все что нужно посоздавать
        ArrayList<String> file_name = new ArrayList<>(Arrays.asList("src1", "res", "savegames", "temp"));
        ArrayList<String> file_src = new ArrayList<>(Arrays.asList("main", "test"));
        ArrayList<String> file_main = new ArrayList<>(Arrays.asList("Main.java", "Utils.java"));
        ArrayList<String> file_res = new ArrayList<>(Arrays.asList("drawables", "vectors", "icons"));
        ArrayList<String> file_temp = new ArrayList<>(Arrays.asList("temp.txt"));

        //Информация о выполнении
        ArrayList<String> info = new ArrayList();

        File dir;
        File dir1;
        File myFile;
        //Создаем дирректории, указанные в file_name
        for (int i =0; i< file_name.size(); i++) {
            dir = new File(file_name.get(i));

            if (dir.mkdir()) {
                info.add("Директория "+ dir + " успешно создана");

                //Если успешно создана дирректория, и ее имя src1
                if (i == 0) {
                    //Создаем в ней два подкаталога, указанных в file_src
                    for (int k = 0; k < file_src.size(); k++) {
                        dir1 = new File(dir + "\\" + file_src.get(k));
                        if (dir1.mkdir()) {
                            info.add("Поддиректория "+ dir1 + " успешно создана");
                            //И если это подкаталог main создаем в нем два файла
                            if (k==0) {
                                for (int j = 0; j < file_main.size(); j++) {
                                    myFile = new File(dir1,file_main.get(j));
                                    try {
                                        if (myFile.createNewFile()) info.add("Файл "+ dir1+"\\"+myFile+" создан" );
                                    } catch (IOException ex){
                                        info.add("Файл "+ dir1+"\\"+myFile+" не создан" );
                                    }
                                }
                            }
                        } else info.add("Поддиректория "+ dir1 + " не была создана");
                    }
                }

                //Если успешно создана дирректория, и ее имя res
                if (i == 1) {
                    for (int k = 0; k < file_res.size(); k++) {
                        dir1 = new File(dir + "\\" + file_res.get(k));
                        if (dir1.mkdir()) {
                            info.add("Поддиректория "+ dir1 + " успешно создана");
                        } else info.add("Поддиректория "+ dir1 + " не была создана");
                    }
                }

                //Если успешно создана дирректория, и ее имя temp
                if (i == 3) {
                    //Создаем в нем файлы из file_temp
                    for (int k = 0; k < file_temp.size(); k++) {
                        myFile = new File(dir,file_temp.get(k));

                        try {
                            if (myFile.createNewFile()) info.add("Файл "+ dir+"\\"+myFile+" создан" );
                        } catch (IOException ex){
                            info.add("Файл "+ dir+"\\"+myFile+" не создан" );
                        }

                    }
                }

            } info.add("Директория "+ dir + " не была создана");

            //Записываем всю полученную информацию в файл temp\temp.txt
            try (FileWriter writer = new FileWriter(file_name.get(3)+"\\"+file_temp.get(0), false)) {
                for (int m = 0; m < info.size(); m++) {
                    writer.write(info.get(m) + "\n");

                }
                writer.flush();
            } catch(IOException ex1){
                System.out.println(ex1.getMessage());
            }
        } // for (int i

    } //main
}
