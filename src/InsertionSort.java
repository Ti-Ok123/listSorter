import utils.ComparableContent;
import utils.List;

public class InsertionSort<ContentType extends ComparableContent<ContentType>> {
    private List<ContentType> list;

    public InsertionSort(List<ContentType> pList) {
        this.list = pList;
    }

    public void insertionSort() {
        int laengeListe = laengeListe();
        for(int a = 0; a < laengeListe; a++){
            for( int b = 0; b < laengeListe-1; b++) {
                list.toFirst();
                for(int k = 1; k < b; k++){
                    list.next();
                }
                ContentType item1 = list.getContent();
                list.toFirst();
                for(int c = 0; c < b; c++){
                    if(item1 > list.getContent()){
                        ContentType item2 = list.getContent();
                    }
                    list.next();
                }

                ContentType item2 = list.getContent();
                if(item1.isGreater(item2)) swap(list,item1,item2);
            }
        }
    }

    public static <ContentType> void swap(List<ContentType> list, ContentType item1, ContentType item2) {
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

    public int laengeListe(){
        int temp = 0;
        list.toFirst();
        while(list.hasAccess()) {
            temp++;
            list.next();
        }
        return temp;
    }

}
