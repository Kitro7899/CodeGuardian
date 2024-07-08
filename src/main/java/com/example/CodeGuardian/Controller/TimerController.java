package com.example.CodeGuardian.Controller;

import com.example.CodeGuardian.Config.MyUserDetails;
import com.example.CodeGuardian.Entity.Timer;
import com.example.CodeGuardian.Entity.User;
import com.example.CodeGuardian.repository.TimerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("test/")
public class TimerController {

    @Autowired
    private TimerRepo timerRepo;

    @PostMapping("/setTimer")
    public String setTimer(@RequestParam int year, @RequestParam int month, @RequestParam int week, @RequestParam int day,
                           @RequestParam int hour, @RequestParam int minute, @RequestParam int second) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails currentUserDetails = (MyUserDetails) authentication.getPrincipal();
        User currentUser = currentUserDetails.getUser();

        LocalDateTime endTime = LocalDateTime.now()
                .plusYears(year)
                .plusMonths(month)
                .plusWeeks(week)
                .plusDays(day)
                .plusHours(hour)
                .plusMinutes(minute)
                .plusSeconds(second);

        Timer timer = new Timer();
        timer.setUser(currentUser);
        timer.setEndTime(endTime);

        timerRepo.save(timer);

        return "redirect:/test/users";
    }

    @PostMapping("/stopTimer")
    public String stopTimer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails currentUserDetails = (MyUserDetails) authentication.getPrincipal();
        User currentUser = currentUserDetails.getUser();

        Optional<Timer> timer = timerRepo.findByUser(currentUser);
        if (timer.isPresent()) {
            timerRepo.delete(timer.get());
        }

        return "redirect:/test/users";
    }

    @PostMapping("/deleteTimer")
    public String deleteTimer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails currentUserDetails = (MyUserDetails) authentication.getPrincipal();
        User currentUser = currentUserDetails.getUser();

        timerRepo.deleteByUser(currentUser);

        return "redirect:/test/users";
    }
}
