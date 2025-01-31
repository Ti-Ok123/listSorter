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
                for(int k = 0; k < j; k++)list.next();
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
            List<ContentType> listCopie = list;
            list.toFirst();
            int i = 1, j = 1;
            while(list.hasAccess() && i != 0 && j != 0){
                if(list.getContent().equals(item1)){
                    list.setContent(item2);
                    i--;
                } else if(list.getContent().equals(item2)){
                    list.setContent(item1);
                    j--;
                } list.next();
            } if(i != 0 || j != 0) list = listCopie;
        }
    }

    public static <ContentType> void swap2(List<ContentType> list, ContentType item1, ContentType item2) {
        if(!list.isEmpty()){
            System.out.println("Getauscht wird: " + item1 + " + " + item2);
            list.toFirst();
            int i = 1, j = 1;
            if(list.getContent().equals(item2)) i++;

            while(list.hasAccess() && !(list.getContent()).equals(item1)){
                i++;
                list.next();
            }
            list.toFirst();
            while(list.hasAccess() && !(list.getContent()).equals(item2)){
                j++;
                list.next();
            }

            list.toFirst();

            if(i < j){
                while(list.hasAccess()){
                    if(list.getContent().equals(item1)){
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
                    if(list.getContent().equals(item2)){
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
