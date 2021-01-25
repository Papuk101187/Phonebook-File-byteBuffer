package сontacts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public class ContactBuffers {
    int lengs = 1025;
    ByteBuffer byteBuffer = ByteBuffer.allocate(lengs);
    FileChannel fileChannel;


    public void writeContact(String contact) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(contact.getBytes());
        byteBuffer.flip();
        FileOutputStream fileOutputStream = new FileOutputStream("Phone book.txt", true);
        fileChannel = fileOutputStream.getChannel();
        for (int i = 1; i < lengs; i++) {
            fileChannel.write(byteBuffer);
        }
        byteBuffer.clear();

    }


    public String[] getArraycontact() throws IOException {
        byteBuffer.clear();
        FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("Phone book.txt"));
        while (true) {
            int size = fileChannel.read(byteBuffer);
            if (size == -1) {
                break;
            }
            byteBuffer.flip();
            return new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()).split(",");

        }
        return new String[0];
    }
}
