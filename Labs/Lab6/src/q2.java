interface NewsSubject {
    /**
     * Registers new observer
     * @return true if succesful, false otherwise
     */
    boolean registerObserver(NewsObserver observer);

    /**
     * Unregisters observer
     * @return true if succesful, false otherwise
     */
    boolean unregisterObserver(NewsObserver observer);

    /**
     * Notifies all observers with the new newsFlash
     */
    void pushNotification(String newsFlash);
}

interface NewsObserver {
    void pushNewsFlash(String newsFlash);
}

class NewsDesk implements NewsSubject {
    private NewsObserver[] observers = new NewsObserver[10];
    private int initialCapacity = 10;
    private int size = 0;
    private String[] news = new String[initialCapacity];


    public boolean registerObserver(NewsObserver observer){
        for(int i=0; i<observers.length; i++){
            if(observers[i] == null){
                observers[i] = observer;
                return true;
            }
        }
        return false;
    }

    public boolean unregisterObserver(NewsObserver observer){
        for(int i=0; i<observers.length; i++){
            if(observers[i] == observer){
                observers[i] = null;
                return true;
            }
        }
        return false;
    }

    public void pushNotification(String newsFlash){
        if(size + 1 < initialCapacity){
            news[size++] = newsFlash;
        }else{
            initialCapacity *= 2;
            String[] temp = new String[initialCapacity];
            for(int i=0; i<size; i++){
                temp[i] = news[i];
            }
            temp[size++] = newsFlash;
            news = temp;
        }
        for(var observer: observers){
            if(observer != null) observer.pushNewsFlash(newsFlash);
        }
    }

    public void printNews(){
        System.out.println("News Summary:");
        for(var summery: news){
            if(summery != null) System.out.println(summery);
        }
    }
}

class Reporter {
    private NewsDesk newsDesk;

    public Reporter(NewsDesk newsDesk){
        this.newsDesk = newsDesk;
    }

    public void discoveredScoop(String newsScoop){
        newsDesk.pushNotification(newsScoop);
    }
}

class BrowserNewsApp implements NewsObserver{
    public void pushNewsFlash(String newsFlash){
        System.out.println("Browser News App News Flash: " + newsFlash);
    }
}

class AndroidNewsApp implements NewsObserver{
    public void pushNewsFlash(String newsFlash){
        System.out.println("Android News App News Flash: " + newsFlash);
    }
}

class IOSNewsApp  implements NewsObserver{
    public void pushNewsFlash(String newsFlash){
        System.out.println("IOS News App News Flash: " + newsFlash);
    }
}