import utils.ComparableContent;
import utils.List;

import java.security.cert.CertStoreException;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {

        this.list = pList;
    }


    public boolean bubbleSort() {
        ContentType Erstes;
        ContentType Zweites;
        int a = 0;
        list.toFirst();
        while (list.hasAccess()) {
            if (list.getContent() == null) {
                return false;
            } else if (list.getContent() != null) {
                Erstes = list.getContent();
                list.next();
                a++;
                Zweites = list.getContent();
                if (Zweites.isLess(Erstes)) {
                    swap(list, Erstes, Zweites);
                    list.toFirst();
                    for (int i =0; a > i; i++){
                        list.next();
                    }
                }
            }
        }
        return false;
    }


    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        ContentType pos1;
        ContentType pos2;
        pos1 = item1;
        pos2 = item2;
        list.toFirst();
        while (list.hasAccess()) {
            if (list.getContent().equals(item2)) {
                list.setContent(item1);
            }
            list.next();
        }
        list.toFirst();
        while (list.hasAccess()) {
            if (list.getContent().equals(item1)) {
                list.setContent(item2);
                return;
            }
            list.next();
        }
    }
}