package com.example.overheard.main.api;

import com.example.overheard.main.user.User;
import com.example.overheard.main.user.UserDao;
import com.example.overheard.main.vote.Vote;
import com.example.overheard.main.vote.VoteDao;

import java.time.LocalDateTime;
import java.util.Optional;

public class VoteService {
    private VoteDao voteDao = new VoteDao();
    private VoteMapper voteMapper = new VoteMapper();

    public void addVote(VoteDto vote) {
        Vote newVote = voteMapper.map(vote);
        voteDao.save(newVote);
    }

    private static class VoteMapper {
        private UserDao userDao = new UserDao();

        Vote map(VoteDto vote) {
            Optional<User> user = userDao.findByUsername(vote.getUsername());
            return new Vote(user.orElseThrow().getId(), vote.getArticleId(),
                    Vote.Type.valueOf(vote.getType()), LocalDateTime.now());
        }
    }
}
