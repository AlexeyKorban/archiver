package ru.ldwx;

public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (size > 0) {
            sb.append("\t");
            sb.append(size / 1024);
            sb.append(" Kb (");
            sb.append(compressedSize / 1024);
            sb.append(" Kb) сжатие: ");
            sb.append(getCompressionRatio());
            sb.append("%");
        }
        return sb.toString();
    }
}
