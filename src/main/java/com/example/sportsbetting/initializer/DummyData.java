package com.example.sportsbetting.initializer;

import com.example.sportsbetting.database.model.*;
import com.example.sportsbetting.database.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DummyData {
    @Autowired
    PlayerService playerService;
    @Autowired
    WagerService wagerService;
    @Autowired
    OutcomeService outcomeService;
    @Autowired
    OutcomeOddService outcomeOddService;
    @Autowired
    BetService betService;
    @Autowired
    FootballSportEventService footballSportEventService;

    public void GenerateData(Player player) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String validFrom = "2000-01-01 12:00:00";
        LocalDateTime validFromDate = LocalDateTime.parse(validFrom, dateFormatter);
        String validTo = "2020-01-01 12:00:00";
        LocalDateTime validToDate = LocalDateTime.parse(validTo, dateFormatter);
        String fromDate = "2020-01-01 12:00:00";
        LocalDateTime dateTime = LocalDateTime.parse(fromDate, dateFormatter);

        OutcomeOdd outcomeOddElement1 = new OutcomeOdd.Builder()
                .setValue(new BigDecimal(2))
                .setValidFrom(validFromDate)
                .setValidUntil(validToDate)
                .build();

        OutcomeOdd outcomeOddElement2 = new OutcomeOdd.Builder()
                .setValue(new BigDecimal(3))
                .setValidFrom(validFromDate)
                .setValidUntil(validToDate)
                .build();
        OutcomeOdd outcomeOddElement3 = new OutcomeOdd.Builder()
                .setValue(new BigDecimal(2))
                .setValidFrom(validFromDate)
                .setValidUntil(validToDate)
                .build();
        OutcomeOdd outcomeOddElement4 = new OutcomeOdd.Builder()
                .setValue(new BigDecimal(3))
                .setValidFrom(validFromDate)
                .setValidUntil(validToDate)
                .build();

        List<OutcomeOdd> outcomeOdd1 = new ArrayList<>();
        outcomeOdd1.add(outcomeOddElement1);
        List<OutcomeOdd> outcomeOdd2 = new ArrayList<>();
        outcomeOdd1.add(outcomeOddElement2);
        List<OutcomeOdd> outcomeOdd3 = new ArrayList<>();
        outcomeOdd1.add(outcomeOddElement3);
        List<OutcomeOdd> outcomeOdd4 = new ArrayList<>();
        outcomeOdd1.add(outcomeOddElement4);

        Outcome outcomeElement1 = new Outcome.Builder()
                .setDescription("First")
                .setOutcomeOdds(outcomeOdd1)
                .build();
        Outcome outcomeElement2 = new Outcome.Builder()
                .setDescription("Second")
                .setOutcomeOdds(outcomeOdd2)
                .build();
        Outcome outcomeElement3 = new Outcome.Builder()
                .setDescription("Third")
                .setOutcomeOdds(outcomeOdd3)
                .build();

        List<Outcome> outcome1 = new ArrayList<>();
        outcome1.add(outcomeElement1);
        List<Outcome> outcome2 = new ArrayList<>();
        outcome2.add(outcomeElement2);
        List<Outcome> outcome3 = new ArrayList<>();
        outcome3.add(outcomeElement3);

        //String pattern = LanguageService.getLocaleBundle().getString("playerScoreGoalMessage");
        //MessageFormat resultFormatter = new MessageFormat(pattern);
        Bet bet1 = new Bet.Builder()
                .setDescription(/*resultFormatter.format(new Object[]{*/"Oliver Giroud"/*})*/)
                .setType(BetType.PLAYERS_SCORE)
                .setWinnerOutcomes(outcome1)
                //            .set
                .build();

        Bet bet2 = new Bet.Builder()
                .setDescription(/*LanguageService.getLocaleBundle().getString(*/"numberOfScoredGoalsMessage"/*)*/)
                .setType(BetType.GOALS)
                .setWinnerOutcomes(outcome2)
                .build();
        Bet bet3 = new Bet.Builder()
                .setDescription(/*LanguageService.getLocaleBundle().getString(*/"winnerBetMessage"/*)*/)
                .setType(BetType.WINNER)
                .setWinnerOutcomes(outcome3)
                .build();

        Set<Bet> bets = new HashSet<Bet>();
        bets.add(bet1);
        bets.add(bet2);
        bets.add(bet3);


        FootballSportEvent footballEvent = (FootballSportEvent) new SportEvent.Builder()
                .setTitle("Arsenal vs Chelsea")
                .setStartDate(dateTime)
                .setEndDate(validToDate)
                .setBets(bets)
                .build(0);


        outcomeOddService.add(outcomeOddElement1);
        outcomeOddService.add(outcomeOddElement2);
        outcomeOddService.add(outcomeOddElement3);
        outcomeOddService.add(outcomeOddElement4);

        betService.add(bet1);
        betService.add(bet2);
        betService.add(bet3);
        footballSportEventService.add(footballEvent);

        Wager wager = new Wager.Builder()
                .setAmount(new BigDecimal(1000))
                .setCurrency(Currency.HUF)
                .setPlayer(player)
                .setProcessed(false)
                .setWin(false)
                .setOdd(outcomeOddElement1)
                .build();

        wagerService.add(wager);
    }
}
