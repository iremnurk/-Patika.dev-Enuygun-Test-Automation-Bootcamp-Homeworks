public class Stories extends Books{
    private  int storiesPoint=2;
    private  int price;//fiyat
    public Stories(String bookName, int pageNumber,int price) {
        super(bookName, pageNumber);

        this.price=price;
    }

    @Override
    void booksPoint() {
        System.out.println(getBookName() + "'s point"+storiesPoint);
        System.out.println("Price:"+price);
        System.out.println("************");
        System.out.println("Discounted Price:"+(price-storiesPoint));


    }
}
