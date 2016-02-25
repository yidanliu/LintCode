import java.util.ArrayList;


//  Definition of Interval:
   class Interval {
      int start, end;
     Interval(int start, int end) {
        this.start = start;
                 this.end = end;
    }
   }


public class InsertInterval {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // write your code here
        int insertIndex = -1;
        for (int i = 0; i < intervals.size()-1; i++) {
        	System.out.println(intervals.get(i).start);
            if (intervals.get(i).start <= newInterval.start &&
                    intervals.get(i+1).start >= newInterval.start) {
                insertIndex = i+1;
            }
        }
        if (insertIndex == -1) {
            if (intervals.size() > 0 && intervals.get(0).start >= newInterval.start) {
                intervals.add(0, newInterval);
            } else {    // add to end
                intervals.add(newInterval);
            }
        } else {
        	intervals.add(insertIndex, newInterval);
        }
        System.out.println(intervals.size());
        ArrayList<Interval> output = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            if (i == 0) {
                output.add(intervals.get(0));
                continue;
            }
            Interval curInterval = intervals.get(i);
            Interval topInterval = output.get(output.size()-1);
            System.out.println(curInterval.start + "," + curInterval.end + "==" + topInterval.start + "," + topInterval.end);
            if (curInterval.start > topInterval.start) {
                if (curInterval.start > topInterval.end) {
                    output.add(curInterval);
                } else if (curInterval.end > topInterval.end) {
                    topInterval.end = curInterval.end;
                }
            } else { // equal
                if (curInterval.end > topInterval.end) {
                    topInterval.end = curInterval.end;
                }
            }
        }
        return output;
    }
}