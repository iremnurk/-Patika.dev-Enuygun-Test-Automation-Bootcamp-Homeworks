public class Novels extends Books{
    private int novelsPoint=3;

    private  int price;//fiyat
    public Novels(String bookName, int pageNumber,int price) {
        super(bookName, pageNumber);
        this.price=price;
    }
    @Override
    void booksPoint() {
        System.out.println(getBookName() + "'s point:"+novelsPoint);
        System.out.println("Price:"+price);
        System.out.println("************");
        System.out.println("Discounted Price:"+(price-novelsPoint));


    }
}
