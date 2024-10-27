package ru.white747.reminderbot.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.white747.reminderbot.configuration.TelegramBotStarterConfiguration;
//import ru.white747.reminderbot.repoditory.UserRepository;

import java.util.*;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    final TelegramBotStarterConfiguration configuration;
//    private final UserRepository userRepository;


    @Autowired
    public TelegramBot(TelegramBotStarterConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getBotUsername() {
        return "Lineage2M_Boss_Reminder";
    }

//    @Override
//    public String getBotUsername() {
//        return "Boss_Reminder_Bot";
//    }


    @Override
    public String getBotToken() {
        return "7610104791:AAEQTeIm7P2pu5f3lxTSSWV9CtacFu44Nqs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("++++++++++++++++++++++++++++++");
        Message msg = update.getMessage();
        User user = msg.getFrom();
        try {
            if (msg.getText().equals("/start")) {
                System.out.println("++++++++++++++++++++++++++++++");
                sendText(user.getId(), "Спать пошел, " + user.getUserName() + "!");
            }
            boolean flagOfMute = false;
            if (msg.isCommand() || !msg.isCommand()) {

            }
            // TODO обработка других команд
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void sendText(Long who, String what) {
        try {
            SendMessage sm = SendMessage.builder()
                    .chatId(who.toString())
                    .text(what).build();
            execute(sm);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

}
