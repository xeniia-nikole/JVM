public class JvmComprehension {
    // 1. Происходит процесс подгрузки класса по схеме
    // Application ClassLoader
    //  🡻          🡹
    // Platform ClassLoader
    //  🡻          🡹
    // Bootstrap ClassLoader
    // 2. Подгруженный класс помещается в Metaspace
    public static void main(String[] args) {
        // 3. В момент вызова main метода в области Stack Memory создается новый Frame
        int i = 1;                      // 4. В Frame записывается примитивная переменная вместе со значением
        Object o = new Object();        // 5. В области памяти Heap создается новый объект типа Object
        // 6. В Frame записывается новая переменная со ссылкой на объект в области памяти Heap
        Integer ii = 2;                 // 7. В области памяти Heap создается новый объект типа Integer
        // 8. В Frame записывается переменная вместе со значением и со ссылкой на объект в области памяти Heap
        printAll(o, i, ii);             // 9. В момент вызова метода printAll в области Stack Memory создается новый Frame
        System.out.println("finished"); // 18. В момент вызова метода System.out.println в области Stack Memory создается новый Frame
        // 19. В области памяти Heap создается новый объект типа StringБ содержащий исходный текст
        // 20. В Frame записывается новая переменная со ссылкой на объект в области памяти Heap
        // 21. Метод System.out.println выполяется и Frame уничтожается
        // 22. Метод main завершает выполнение и Frame уничтожается
    }

    private static void printAll(Object o, int i, Integer ii) {
        // 10. В Frame записываются переменные
        Integer uselessVar = 700;                   // 11. В области памяти Heap создается новый объект типа Integer
        // В Frame записывается переменная вместе со значением и со ссылкой на объект в области памяти Heap
        System.out.println(o.toString() + i + ii);  // 12. В момент вызова метода System.out.println в области Stack Memory создается новый Frame
        // 13. Во Frame записываются переменные
        // 14. В момент вызова метода toString в области Stack Memory создается новый Frame
        // 15. Во Frame записывается переменная
        // 16. Метод toString выполняется и Frame уничтожается
        // 17. Метод System.out.println выполяется и Frame уничтожается
    }
}