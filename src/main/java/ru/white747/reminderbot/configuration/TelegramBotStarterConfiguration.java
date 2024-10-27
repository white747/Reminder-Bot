package ru.white747.reminderbot.configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.white747.reminderbot.service.TelegramBot;

@Configuration
public class TelegramBotStarterConfiguration {
    @Bean
    TelegramBotsApi telegramBotsApi(TelegramBot bot) throws TelegramApiException {
        var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
        return telegramBotsApi;
    }

//        @PostConstruct
//    public void start() {
//        try {
//
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//
//
//            botsApi.registerBot(new TelegramBot());
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//    }

}