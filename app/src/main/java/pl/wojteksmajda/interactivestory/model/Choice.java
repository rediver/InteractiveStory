package pl.wojteksmajda.interactivestory.model;

/**
 * Created by wojtek on 15.05.17.
 */

public class Choice {

        private int textid;
        private int nextPage;

        public Choice(int textid, int nextPage) {
            this.textid = textid;
            this.nextPage = nextPage;
        }

        public int getTextid() {
            return textid;
        }

        public void setTextid(int textid) {
            this.textid = textid;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

}
