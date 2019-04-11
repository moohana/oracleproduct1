package com.stackroute.queryautocorrector.corrector;

/* Created on : 28/03/2019 by Subhajit Pal (@rahzex) */

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

import java.io.IOException;
import java.util.List;

public class QueryAutoCorrector {

    /* This method returns corrected queryAnswer after removing any spelling errors */

    public static String correctQuery(String query) throws IOException {

        JLanguageTool langTool = new JLanguageTool(new BritishEnglish());

        /* Checking for spelling errors */
        List<RuleMatch> matches = langTool.check(query);
        String correctedQuery = query;

        for (RuleMatch match : matches) {
            /* Getting incorrect word from the queryAnswer */
            String incorrectWord = query.substring(match.getFromPos(),match.getToPos());

            if(!match.getSuggestedReplacements().isEmpty()){
                /* Getting the first correct word suggestion from list */
                String correctedWord = match.getSuggestedReplacements().get(0);

                /* Auto correcting the queryAnswer word by word */
                if (match.getFromPos() == 0)
                    correctedQuery = correctedQuery.replaceFirst(incorrectWord,correctedWord);
                else if (match.getToPos() == query.length())
                    correctedQuery = correctedQuery.replaceFirst(" "+incorrectWord," "+correctedWord);
                else
                    correctedQuery = correctedQuery.replaceFirst(" "+incorrectWord+" "," "+correctedWord+" ");
            }

        }

        return correctedQuery;
    }
}
