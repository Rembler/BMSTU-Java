import java.util.ArrayList;
import java.util.HashSet;

public class CommonWordsFinder {
    private final ArrayList<HashSet<String>> _sentenceWords;
    private int _maxDepth;

    public CommonWordsFinder(ArrayList<HashSet<String>> sentenceWords) {
        _sentenceWords = sentenceWords;
        _maxDepth = 1;
    }

    public void findSentencesWithCommonWords() {
        for (int i = 0; i < _sentenceWords.size(); i++) {
            findSentencesWithCommonWords(i, new HashSet<>());
        }
    }

    public int getMaxDepth() {
        return _maxDepth;
    }

    private void findSentencesWithCommonWords(int i, HashSet<Integer> checkedSentences) {
        checkedSentences.add(i);

        var achievedDepth = checkedSentences.size();

        if (achievedDepth > _maxDepth) {
            _maxDepth = achievedDepth;
        }

        for (int j = 0; j < _sentenceWords.size(); j++) {
            if (checkedSentences.contains(j)) {
                continue;
            }

            var intersection = new HashSet<>(_sentenceWords.get(i));
            var currentSentenceWords = _sentenceWords.get(j);

            intersection.retainAll(currentSentenceWords);

            if (intersection.size() > 0) {
                findSentencesWithCommonWords(j, checkedSentences);
            }
        }

        checkedSentences.remove(i);
    }
}
