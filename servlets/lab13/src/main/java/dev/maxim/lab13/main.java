package dev.maxim.lab13;

public class main {
    public static void main(String[] args) {
        NoteBookStore noteBookStore = new NoteBookStore("store.txt");
        noteBookStore.update("Nastya", "1252342134");
        noteBookStore.update("Denis", "42134");
        noteBookStore.update("Maxim", "42666666134");

        noteBookStore.save();
//        System.out.println(noteBookStore);
//
        noteBookStore.load();
        noteBookStore.update("Maxim", "4266666613477777");
        noteBookStore.save();
    }
}
