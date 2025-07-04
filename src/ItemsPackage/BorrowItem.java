package ItemsPackage;

import java.time.LocalDate;


/*
 * هذا الكلاس مخصص للزبائن
 * كل كائن فيه عنصر مستعار
 * تاريخ الاستعارة
 * تاريخ الاستلام
 * عملنا هذا الكلاس كرمال ما نحط بقلب كلاس الbook والprojects هدول المتغيرات
 */


public class BorrowItem {


    /*--------Attributes--------*/
    private LocalDate dateBorrow;
    public Item item;
    private LocalDate dateReturn;


    /*--------Constructors--------*/
    public BorrowItem(LocalDate dateBorrow, LocalDate dateReturn, Item item) {
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.item = item;
    }


    /*--------Setter and Getter--------*/

    public LocalDate getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDate dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public LocalDate getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(LocalDate dateReturn) {
        this.dateReturn = dateReturn;
    }

//    public boolean isOverdue() {
//        long now = new Date().getTime();
//        long difference = now - dateBorrow.getTime(); // Error from getTime Method
//        return dateReturn == null && difference > 7L * 24 * 60 * 60 * 1000;
//    }
//
//    public boolean isReturned() {
//        return dateReturn != null;
//    }

}
