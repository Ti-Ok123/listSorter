import utils.ComparableContent;
import utils.List;

public class InsertionSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public InsertionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void insertionSort() {
        for(int i = 0; i < laengeList(list); i++){
            list.toFirst();
            for(int k = 0; k < i; k++) list.next();
            ContentType currentItem = list.getContent();
            list.toFirst();
            for(int k = 0; k < i + 1; k++){
                if(currentItem.isGreater(list.getContent())){
                    list.next();
                } else if(currentItem.isLess(list.getContent())){
                    list.insert(currentItem);
                    while(!list.getContent().equals(currentItem)) list.next();
                    list.remove();
                    break;
                } else break;
            }
        }
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


    public int laengeList(List<ContentType> list){
        if(list.isEmpty() || list == null) return 0;
        int laenge = 0;
        list.toFirst();
        while(list.hasAccess()){
            laenge++;
            list.next();
        } return laenge;
    }
}
