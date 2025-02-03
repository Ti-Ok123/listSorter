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
        int l = 0;
        boolean ok = false;
        ContentType lol = null;

        list.toFirst();
        while(list.hasAccess()){
            x = 0;
            i = x;
            list.toFirst();
            l = y;
            while (l > 0){
                list.next();
                l--;
            }
            lol = list.getContent();
            while(ok == false){
                if(lol.isGreater(list.getContent())){
                    lol = list.getContent();
                    list.next();
                    x++;
                    i = x;
                    if(list.getContent() == null){
                        ok = true;
                    }
                } else if(lol.isEqual(list.getContent())){
                    list.next();
                    if(list.getContent() == null){
                        list.toLast();
                        list.next();
                        ok = true;
                        lol = null;
                    }
                    x++;
                } else if(lol.isLess(list.getContent())){
                    list.next();
                    if(list.getContent() == null){
                        ok = true;
                    }
                    x++;
                }
            }
            if (!(lol == null)) {
                ok = false;
                list.toFirst();
                while (i - 1 + y > 0) {
                    list.next();
                    i--;
                }
                i = x;
                list.remove();
                y++;
                l = y;

                list.toFirst();
                while (l > 1) {
                    list.next();
                    l--;
                }
                list.insert(lol);
            }

        }

    }

    public int length(){
        int y = 1;
        list.toFirst();
        while(list.hasAccess()){
            list.next();
            y++;
        }
        return y;
    }
}