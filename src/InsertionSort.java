import utils.ComparableContent;
import utils.List;

import java.util.concurrent.Callable;

public class InsertionSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public InsertionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void insertionSort() {
    int i = 0;
    int x = 0;
    int y = 0;
    boolean hä = false;
    ContentType r = null;

    list.toFirst();
    list.next();
    while(list.hasAccess()){
        System.out.println(r);
        r = list.getContent();
        System.out.println(r);
        list.remove();
        list.toFirst();
        while(hä == false){
            if(r.isGreater(list.getContent())){
                list.next();
                i++;
            }else if(r.isLess(list.getContent())){
                list.toFirst();
                while(i > 0){
                    i--;
                    list.next();
                }
                System.out.println(r);
                list.insert(r);
                System.out.println(r);
                x++;
                y = x;
                hä = true;
            }
        }
        hä = false;
        list.toFirst();
        while(y > 0){
            list.next();
            y--;
        }
        y = x;
        System.out.println(list.getContent());
       // if(x == length() ) {
         //   list.toLast();
           // list.next();
        //}
        System.out.println(list.getContent());
        System.out.println(r);
    }
    }

    public int length(){
        int y = 0;
        list.toFirst();
        while(list.hasAccess()){
            list.next();
            y++;
        }
        return y;
    }

}
