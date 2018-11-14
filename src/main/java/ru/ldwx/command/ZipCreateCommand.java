package ru.ldwx.command;

import ru.ldwx.ConsoleHelper;
import ru.ldwx.ZipFileManager;
import ru.ldwx.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipCreateCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            zipFileManager.createZip(sourcePath);

            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Вы не верно указали имя файла или директории.");
        }
    }
}
