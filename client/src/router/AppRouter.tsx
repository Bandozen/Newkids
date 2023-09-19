import React from 'react';
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import { GlobalFonts } from 'styles/GlobalFonts';
import { GlobalStyles } from 'styles/GlobalStyles';
import ApplicationLayout from 'layouts/common/ApplicationLayout';
import { GlobalKeyFrames } from 'styles/GlobalKeyFrames';
import Navigation from 'components/organisms/common/Navigation';
import IndexPage from 'pages/IndexPage';
import LoginPage from 'pages/LoginPage';
import MyPage from 'pages/MyPage';
import PrivateRoute from './PrivateRoute';

function AppRouter() {
	return (
		<RecoilRoot>
			<GlobalFonts />
			<GlobalStyles />
			<GlobalKeyFrames />
			<ApplicationLayout>
				<BrowserRouter>
					<Navigation />
					<Routes>
						<Route path="/" element={<Navigate to="/index" />} />
						<Route path="/index" element={<IndexPage />} />
						<Route path="/index/auth/login" element={<LoginPage />} />
						<Route path="/index/mypage/info" element={<MyPage />} />

						<Route path="/" element={<PrivateRoute />}>
							<Route path="/game" element={<div />} />
							<Route path="/quiz" element={<div />} />
						</Route>
					</Routes>
				</BrowserRouter>
			</ApplicationLayout>
		</RecoilRoot>
	);
}

export default AppRouter;
