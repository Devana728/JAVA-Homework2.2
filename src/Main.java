//Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        int[] mas = {11, 3, 14, 16, 7, 1};

        boolean isSorted = false;
        int buf;
        Logger logger = Logger.getLogger(Main.class.getName());

        FileHandler fh = null;
        try {
            fh = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.addHandler(fh);

        SimpleFormatter sFormat = new SimpleFormatter();

        fh.setFormatter(sFormat);


        logger.info("началась сортировка");
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }

            }
            logger.info(Arrays.toString(mas));
        }
        logger.info("закончилась сортировка");
        System.out.println(Arrays.toString(mas));
    }
}
