import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { RecoilRoot } from 'recoil';
import { GlobalFonts } from 'styles/GlobalFonts';
import { GlobalStyles } from 'styles/GlobalStyles';
import ApplicationLayout from 'layouts/common/ApplicationLayout';
import { GlobalKeyFrames } from 'styles/GlobalKeyFrames';
import Navigation from 'components/organisms/common/Navigation';
import IndexPage from 'pages/IndexPage';
import QuizPage from 'pages/QuizPage';
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
						<Route path="/" element={<IndexPage />} />
						<Route path="/account/login" element={<div />} />
						<Route path="/" element={<PrivateRoute />}>
							<Route path="/game" element={<div />} />
							<Route path="/quiz" element={<QuizPage />} />
						</Route>
					</Routes>
				</BrowserRouter>
			</ApplicationLayout>
		</RecoilRoot>
	);
}

export default AppRouter;
