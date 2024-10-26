package ru.white747.reminderbot.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor
@Slf4j
public class TelegramBot extends TelegramLongPollingBot {

    private final TelegramBotStarterConfiguration configuration;
    private final UserRepository userRepository;


    @Override
    public String getBotUsername() {
        return "lineage2M_Boss_Reminder";
    }

    @Override
    public String getBotToken() {
        return "6154995406:AAGkGISipT8UoHHs7qmuKC-B1r32mlv72us";
    }


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message msg = update.getMessage();
        User user = msg.getFrom();
        try {
            boolean flagOfMute = false;
            if (msg.isCommand() || !msg.isCommand()) {
                if (msg.getText().equals("/start")) {
                    // TODO захреначить регистрацию пользователя
                }
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
