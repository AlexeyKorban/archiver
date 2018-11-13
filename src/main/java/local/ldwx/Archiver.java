package local.ldwx;

import local.ldwx.exception.WrongZipFileException;

import java.io.IOException;

import static local.ldwx.ConsoleHelper.readInt;
import static local.ldwx.ConsoleHelper.writeMessage;

public class Archiver {
    public static void main(String[] args) {
        Operation operation = null;
        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                writeMessage("Произошла ошибка. Проверьте введенные данные");
            }

        } while (operation != Operation.EXIT);
    }

    public static Operation askOperation() throws IOException {
        writeMessage("");
        writeMessage("Выберите операцию");
        writeMessage(String.format("\t %d - упаковать файлы в архив", Operation.CREATE.ordinal()));
        writeMessage(String.format("\t %d - добавить файл в архив", Operation.ADD.ordinal()));
        writeMessage(String.format("\t %d - удалить файл из архива", Operation.REMOVE.ordinal()));
        writeMessage(String.format("\t %d - распаковать архив", Operation.EXTRACT.ordinal()));
        writeMessage(String.format("\t %d - просмотреть содержимое архива", Operation.CONTENT.ordinal()));
        writeMessage(String.format("\t %d - выход", Operation.EXIT.ordinal()));
        return Operation.values()[readInt()];
    }
}
