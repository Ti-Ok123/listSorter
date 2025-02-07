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
        int e = length();
        boolean ok = false;
        ContentType lol = null;

        while(e > 0){
            list.toFirst();
            i = x;
            while (i > 0){
                list.next();
                i--;
            }
            i = x;
            lol = list.getContent();
            list.next();
            while(list.hasAccess()){
                if(lol.isGreater(list.getContent())){
                    lol = list.getContent();
                    list.next();
                } else if(lol.isEqual(list.getContent())){
                    list.next();
                    if(!list.hasAccess()){
                        list.toLast();
                        list.next();
                    }
                } else if(lol.isLess(list.getContent())){
                    list.next();
                }
            }
            e--;
            list.toFirst();
            i = x;
            while (i > 0){
                list.next();
                i--;
            }
            i = x;
            while(!lol.isEqual(list.getContent())){
                list.next();
            }

            list.remove();

            list.toFirst();
            while(i > 0){
                list.next();
                i--;
            }
            list.insert(lol);
            if(!list.hasAccess()){
                list.append(lol);
            }
            x++;
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