package ru.white747.reminderbot.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.white747.reminderbot.configuration.TelegramBotStarterConfiguration;
import ru.white747.reminderbot.repoditory.UserRepository;

import java.util.*;

@Component
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    final TelegramBotStarterConfiguration configuration;
    final UserRepository userRepository;


    @Autowired
    public TelegramBot(TelegramBotStarterConfiguration configuration, UserRepository userRepository) {
        this.configuration = configuration;
        this.userRepository = userRepository;
    }

    @Value("${telegram.token}")
    private String token;

    @Value("${telegram.name}")
    private String name;


    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return name;
    }


    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        User user = msg.getFrom();
        try {
            if (msg.getText().equals("/start")) {
                String name = "";
                if (user.getUserName()!=null && !user.getUserName().isEmpty()) {
                    name = user.getUserName();
                }
                sendText(user.getId(), "Пользователь, " + name + " идентифицирован!");
                ru.white747.reminderbot.model.User user1 = new ru.white747.reminderbot.model.User();
                user.setId(user.getId());
                user1.setName(name);
                userRepository.save(user1);
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
