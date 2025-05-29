package Exceptions;

public class SuppressedClose {
    static class Loud implements AutoCloseable {
        @Override public void close() throws Exception {
            throw new Exception("close");
        }
    }
    public static void main(String[] args) {
        try (Loud l = new Loud()) {
            throw new Exception("body");
        } catch (Exception e) {
            System.out.println(e.getMessage());               // body
            System.out.println(e.getSuppressed()[0].getMessage()); // close
        }
    }
}
