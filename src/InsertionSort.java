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
    int e = length() - 1;
    boolean hä = false;
    ContentType r = null;
    ContentType q = null;

    list.toFirst();
    list.next();
    while(list.hasAccess()){
        r = list.getContent();
        x++;
        list.remove();
        q = list.getContent();
        list.toFirst();
        while(hä == false) {
            if (r.isGreater(list.getContent())) {
                list.next();
                if(!list.getContent().equals(q) && !(q == null)){
                    i++;
                } else {
                    list.append(r);
                    hä = true;
                }
            } else if(r.isEqual(list.getContent())){
                list.next();
                i++;
            } else if(r.isLess(list.getContent())){
                list.toFirst();
                while(i > 0){
                    i--;
                    list.next();
                }
                list.insert(r);
                y = x;
                hä = true;
            }
        }
        i = 0;
        hä = false;
        list.toFirst();
        while(y >= 0){
            list.next();
            y--;
        }
        y = x;
        if(x == e ) {
            list.toLast();
            list.next();
        }
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
