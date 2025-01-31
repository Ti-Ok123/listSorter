import utils.ComparableContent;
import utils.List;

import javax.swing.text.AbstractDocument;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        for(int i = 0; i < laengeList(list); i++){
            for(int j = 0; j < laengeList(list) - 1; j++){
                list.toFirst();
                int tmp = 0;
                while(tmp < j){
                    tmp++;
                    list.next();
                }
                ContentType item1 = list.getContent();
                list.next();
                ContentType item2 = list.getContent();
                if(item1.isGreater(item2)) swap(list, item1, item2);
            }
        }
    }

    public int laengeList(List<ContentType> list){
        if(list.isEmpty() || list == null) return 0;
        int laenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            laenge++;
            list.next();
        } return laenge;
    }

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        if(!list.isEmpty()){
            System.out.println("Getauscht wird: " + item1 + " + " + item2);
            list.toFirst();
            int i = 1, j = 1;
            MyNumber item_1 = (MyNumber) item1;
            MyNumber item_2 = (MyNumber) item2;
            if(list.getContent().equals(item_2)) i++;

            while(list.hasAccess()){
                if(list.getContent().equals(item1)) System.out.println("ja");
                list.next();
            }
            list.toFirst();

            while(list.hasAccess() && !((MyNumber)list.getContent()).isEqual(item_1)){
                i++;
                list.next();
            }
            list.toFirst();
            while(list.hasAccess() && !((MyNumber)list.getContent()).isEqual(item_2)){
                j++;
                list.next();
            }

            list.toFirst();

            if(i < j){
                while(list.hasAccess()){
                    MyNumber listElement = (MyNumber) list.getContent();
                    if(listElement.isEqual(item_1)){
                        list.insert(item2);
                        list.remove();
                    }  list.next();
                }
                list.toFirst();
                for(int k = 1; k < j; k++) list.next();
                list.insert(item1);
                list.remove();
            } else if (i > j){
                while(list.hasAccess()){
                    MyNumber listElement = (MyNumber) list.getContent();
                    if(listElement.isEqual(item_2)){
                        list.insert(item1);
                        list.remove();
                    }  list.next();
                }
                list.toFirst();
                for(int k = 1; k < i; k++) list.next();
                list.insert(item2);
                list.remove();
            }
        }
    }
}
