import styled from 'styled-components';

export const QuizQuestionContainer = styled.div`
	min-height: calc(100vh);

	.question-box {
		width: 800px;
		height: 500px;
		padding: 20px;
		box-shadow: 0 0 0 5px rgba(1, 1, 0, 0.5);
		border-radius: 25px;
		display: block;
		margin-left: auto;
		margin-right: auto;
		margin-top: 3rem;
	}

	.quiz-button {
		display: flex;
		justify-content: center;
		align-item: center;
		margin-top: 3rem;
	}
`;
