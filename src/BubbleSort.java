import utils.ComparableContent;
import utils.List;

public class BubbleSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public BubbleSort(List<ContentType> pList) {
        this.list = pList;
    }


    public void bubbleSort() {
        int lenge = lengeListe();
        ContentType a;
        ContentType b;

        for(int i = 0; i < lenge; i++){
            list.toFirst();
            a = list.getContent();
            list.next();
            b = list.getContent();
            for(int j = 0; j < (lenge - i) ; j++){
                if(a.isGreater(b)){
                    swap(list, a,b);
                }
                a = list.getContent();
                list.next();
                b = list.getContent();
            }

        }
    }

    public int lengeListe(){
        int lenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            lenge++;
            list.next();
        }
        return lenge;
    }

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {


    }
}
