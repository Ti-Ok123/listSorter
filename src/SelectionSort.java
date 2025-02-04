import utils.ComparableContent;
import utils.List;

import java.util.concurrent.Callable;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void selectionSort() {
        int i = 0;
        int x = 0;
        int y = 0;
        int g = 0;
        boolean ok = false;
        ContentType lol = null;

        list.toFirst();
        while(list.hasAccess()) {
            list.toFirst();
            x = 0;
            y = g;
            while(y > 0){
                list.next();
                y--;
            }
            lol = list.getContent();
            while(ok == false){
                if(lol.isGreater(list.getContent())){
                    lol = list.getContent();
                    i = x;
                    list.next();
                    x++;
                    if(list.getContent() == null){
                        list.toLast();
                        list.next();
                        ok = true;
                    }
                } else if(lol.isEqual(list.getContent())){
                    list.next();
                    x++;
                    if(list.getContent() == null){
                        list.toLast();
                        list.next();
                        ok = true;
                    }
                } else if(lol.isLess(list.getContent())){
                    list.next();
                    x++;
                    if(list.getContent() == null){
                        list.toLast();
                        list.next();
                        ok = true;
                    }
                }
            }
            ok = false;
            list.toFirst();
            while(i > 0){
                list.next();
                i--;
            }
            list.remove();

            list.toFirst();
            while (y > 0) {
                list.next();
                y--;
            }
            g++;
            list.insert(lol);
        }
    }
}