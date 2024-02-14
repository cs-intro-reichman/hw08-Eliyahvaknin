/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];// Array of track objects
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {// Get the track
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        if (size == maxSize) {
        return false;
        }  
        if (size == 0){
            tracks[0] = track;
            size++;
         return true;
        }
        if(size>=0){  
        tracks[size] = track;
            size++;
            return true;
       }
        return false;
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() {
        StringBuilder listOfSongs= new StringBuilder("\n");//String.valueOf(size
        for (int i = 0; i < maxSize ; i++) {
            if(tracks[i]==null){
                continue;
            }
            if(tracks.length!=size && tracks[i]!=null ){
                listOfSongs.append(tracks[i].getTitle())
                        .append(", ")
                        .append(tracks[i].getArtist())
                        .append(", ")
                        .append(tracks[i].getDuration())
                        .append("\n");


            }
        }

    return listOfSongs.toString();

    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() {
    if (size == 0) {
        return;
    }
    int counter = 0;
    for (int i=0; i<maxSize; i++){
        if (tracks[i]!= null){
            counter++;
        }
        if (counter == size){
            tracks[i] = null;
            size--;
            return;
        }
    }
              
    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() {
        int count = 0;
        for (int i = 0; i < maxSize; i++) {
            if(tracks[i]==null){
                continue;
            }
            count += tracks[i].getDuration();           
        }
        return count;
    }


    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) {
        for (int i = 0; i < maxSize; i++) {
            if(tracks[i]==null){
                continue;
            }
            if(tracks[i].getTitle().equals(title)){
                return i;
            }
        }
        return -1;
    }


 
    public boolean add(int i, Track track) {
       if(size == 0){
        tracks[0] = track;
        size++;
        return true;
       }
       if((i<0) || (i > maxSize) || (maxSize==size) ){
           return false;
       }
       for(int j = size; j>i; j--){
        tracks[j] = tracks[j-1];
        if (i == j){
            tracks[i] = track;
            size++;
            return true;
        }
        size++;
        return true;
      }                      
       return false;
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) {
       if ((size == 0) || (i < 0) || (i > maxSize)){
        System.out.println(-1);
       }
       tracks[i] = null;
        size--;
    }

 
    public void remove(String title) {
        if(size==0 ){
            return;
        }    
        remove(indexOf(title));
        }


    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst()  {
        if(size ==0){
            return;
         }
        remove(0);


     }

    /** Adds all the tracks in the other list to the end of this list. 
     *  If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) {
        if(other.size + size > maxSize) {
            return;
        } 
        for(int i = 0; i < other.maxSize; i++) {
            
            for(int j = 0; j < maxSize; j++) {
            if (other.tracks[i]!=null && tracks[j]==null) {
                tracks[j] = other.tracks[i];
                size++;
                break;
            }

        }
    }
    }


    private int minIndex(int start) {
        if(start < 0 || start > size-1  ) {
            return -1;
       }
       int minimum = -1;
       int helper=0;
       if(tracks[start] != null){
           minimum = tracks[start].getDuration();
        }
       for (int i = start; i < size; i++) {
           if(tracks[i]== null){
               continue;
              }
               if(minimum > tracks[i].getDuration()){
                   minimum = tracks[i].getDuration();
                    helper = i;                      
       }
   }
   return helper + start;
}


 
    public String titleOfShortestTrack() {
        if(size==0) {
            return null;
        }        
        return tracks[minIndex(0)].getTitle();
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() {
        for (int i = 0; i < size - 1; i++) {
            if(tracks[i] == null){
                continue;
            }
        int minIndex = i;
        for (int j = i + 1; j < size; j++) {
            if(tracks[j]==null){
                continue;
            }
            if (tracks[j].getDuration() < tracks[minIndex].getDuration()) {
                minIndex = j;
            }
        }
        
        swap(tracks, i, minIndex);
            }
        }
        public void swap(Track[] array, int i, int j) {
            //swapping
            Track temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    




