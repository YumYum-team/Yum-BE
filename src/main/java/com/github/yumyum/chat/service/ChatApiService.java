package com.github.yumyum.chat.service;

import com.github.yumyum.chat.entity.Friendship;
import com.github.yumyum.chat.entity.Member;
import com.github.yumyum.chat.repository.FriendshipRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ChatApiService {

    private final FriendshipRepository friendshipRepository;

    @Transactional
    public int isUsersFriend(final int memberId1, final int memberId2) {
        return friendshipRepository.exists(memberId1, memberId2);
    }

//    @Transactional
//    public void makeFreindship(final int memberId1, final int memberId2) {
////        Friendship friendship = friendshipRepository.findByMemberId1AndMemberId2(memberId1, memberId2)
////                .orElseThrow(IllegalArgumentException::new);
////        friendshipRepository.findByMemberId1AndMemberId2(memberId1, memberId2);
//    }

//    @Transactional
//    public void breakFreindship() {
//        boolean byMemberId1 = friendshipRepository.existsByMemberId1(1);
//        log.info("byMemberId1: {}", byMemberId1);
//    }
//
    @Transactional
    public List<Friendship> getFriends() {
        return friendshipRepository.findAll();
    }

    /**
     * friendship table에서 row (id1, id2), (id2, id1) 2개씩 저장
     * 참고: https://okky.kr/questions/590874 마지막 댓글 참고)
     * @param memberId1
     * @param memberId2
     */
    @Transactional
    public void makeFriend(final int memberId1, final int memberId2) {
        Friendship friendship1 = Friendship.builder()
                .member1(Member.builder().memberId(memberId1).build())
                .member2(Member.builder().memberId(memberId2).build())
                .build();
        Friendship friendship2 = Friendship.builder()
                .member1(Member.builder().memberId(memberId2).build())
                .member2(Member.builder().memberId(memberId1).build())
                .build();

        friendshipRepository.save(friendship1);
        friendshipRepository.save(friendship2);
    }

    public String checkMembersFriendShip(int userId1, int friendShipSearchId) {
        if (userId1 == friendShipSearchId) {
            return String.format("자기 자신과 친구 관계를 맺을 수 없습니다.");
        }

        if (isUsersFriend(userId1, friendShipSearchId) > 0) {
            return String.format("%s와 %s는 이미 친구입니다.", userId1, friendShipSearchId);
        }

        makeFriend(userId1, friendShipSearchId);
        return String.format("%s와 %s는 친구가 되었습니다.", userId1, friendShipSearchId);
    }

//
//    @Transactional
//    public void createChatroom() {
//
//    }
//
//    @Transactional
//    public void joinChatroom() {
//
//    }
//
//    @Transactional
//    public void leaveChatroom() {
//
//    }
//
//    @Transactional
//    public void getChatroomList() {
//
//    }
}
