import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        list.toFirst();
        ContentType uno = list.getContent();
        list.next();
        ContentType dos = list.getContent();
        for (int i = 0; i <= 5 ;i++) {
            list.toFirst();
            while (list.hasAccess()) {

                if (uno.isGreater(dos)) {
                    swap(list, uno, dos);
                } else if (uno.isEqual(dos)) {
                } else if (uno.isLess(dos)) {
                    list.next();
                }
            }
        }
    }

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
        list.toFirst();
        while (list.hasAccess()){
            if(list.getContent().equals(item2)) {
                list.setContent(item1);
            }else if(list.getContent().equals(item1)){
               list.setContent(item2);
            }
            list.next();
        }
        }
    }

