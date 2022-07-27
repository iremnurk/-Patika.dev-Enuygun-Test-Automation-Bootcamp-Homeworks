public abstract  class Books {
    private String bookName;
    private int pageNumber;

    public Books(String bookName, int pageNumber) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
    }

    public void info() {


        System.out.println("Book Name " + bookName + "Page Number "+pageNumber);
    }
    abstract void booksPoint();     //hikaye  2 , Roman  3 puan  vererek genel fiyatı indiren sistem

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

}