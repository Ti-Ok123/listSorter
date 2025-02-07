import utils.ComparableContent;
import utils.List;

public class SelectionSort<ContentType extends ComparableContent<ContentType>> {

    private List<ContentType> list;

    public SelectionSort(List<ContentType> pList) {
        this.list = pList;
    }



    public void selectionSort() {
        if (list.isEmpty()){
            return;
        } else {
            for (int i = getLength(list); 0 <= i; i--){
                list.toFirst();
                ContentType temp = list.getContent();
                while(list.hasAccess()){
                    list.next();
                    if (list.hasAccess()) {
                        if (temp.isLess(list.getContent())) {
                            temp = list.getContent();
                        }
                    }
                }
                list.toFirst();
                for (int j = 0; j <= i - 1; j++) {
                    list.next();
                }
                swap(list, temp, list.getContent());
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
    }

    /**
     * i wird nicht größer, problem suchen
     */
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
