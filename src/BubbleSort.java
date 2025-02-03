import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        if (list.isEmpty()) {
            return;
        } else {
                for (int a = getLength(list); 0 <= a; a--) {
                    list.toFirst();
                    while (list.hasAccess()) {
                        ContentType temp = list.getContent();
                        list.next();
                        if (list.hasAccess()){
                        if (list.getContent().isLess(temp)) {
                            ContentType temp1 = list.getContent();
                            swap(list, temp, list.getContent());
                            list.toFirst();
                            while (!list.getContent().equals(temp1)) {
                                list.next();
                            }
                        }
                        }
                    }
            }
        }
    }


    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        if (list.isEmpty() || item1.equals(item2)) {
            return;
        }


        list.toFirst();
        boolean gefunden1 = false;
        boolean gefunden2 = false;
        ContentType temp1 = item1;
        ContentType temp2 = item2;


        while (list.hasAccess()) {
            if (list.getContent().equals(item1)) {
                temp1 = list.getContent();
                gefunden1 = true;
            } else if (list.getContent().equals(item2)) {//
                temp2 = list.getContent();
                gefunden2 = true;
            }
            list.next();
        }

        if (gefunden1 && gefunden2) {
            list.toFirst();
            while (list.hasAccess()) {
                if (list.getContent().equals(item1)) {
                    list.setContent(temp2);
                } else if (list.getContent().equals(item2)) {
                    list.setContent(temp1);
                }

                list.next();
            }
        }
    } ///

    public int getLength(List<ContentType> list){
        list.toFirst();
        int i = 0;
        while(list.hasAccess()){
            i++;
            list.next();
        }
        list.toFirst();
        return i;
    }
}

