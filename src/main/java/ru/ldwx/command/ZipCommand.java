package ru.ldwx.command;

import ru.ldwx.ConsoleHelper;
import ru.ldwx.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите польный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}
