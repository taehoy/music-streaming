// accessToken + refreshToken 저장
function storeTokens({ accessToken, refreshToken }) {
    localStorage.setItem("accessToken", accessToken);
    localStorage.setItem("refreshToken", refreshToken);
}

// 로그아웃 처리
function logout() {
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
    window.location.href = "/login";
}

// 인증 fetch → 401일 경우 refresh 시도 후 재요청
async function authenticatedFetch(url, options = {}) {
    const accessToken = localStorage.getItem("accessToken");

    const res = await fetch(url, {
        ...options,
        headers: {
            ...(options.headers || {}),
            Authorization: `Bearer ${accessToken}`,
            "Content-Type": "application/json"
        }
    });

    if (res.status === 401) {
        const refreshToken = localStorage.getItem("refreshToken");

        const refreshRes = await fetch("/auth/reissue", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ refreshToken })
        });

        if (!refreshRes.ok) {
            alert("세션이 만료되었습니다. 다시 로그인해주세요.");
            logout();
            return;
        }

        const data = await refreshRes.json();
        storeTokens(data);

        return await authenticatedFetch(url, options); // ✅ 원래 요청 재시도
    }

    return res;
}
